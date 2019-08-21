/**
 * 对比两个对象是否相等(属性和值完全相等)，深度比较
 */
function CompareObj(objA, objB, flag) {
	for (var key in objA) {
		if (!flag) //跳出整个循环
			break;
		if (!objB.hasOwnProperty(key)) { flag = false; break; }
		if (!isArray(objA[key])) { //子级不是数组时,比较属性值
			if (objB[key] != objA[key]) { flag = false; break; }
		} else {
			if (!isArray(objB[key])) { flag = false; break; }
			var oA = objA[key], oB = objB[key];
			if (oA.length != oB.length) { flag = false; break; }
			for (var k in oA) {
				if (!flag) //这里跳出循环是为了不让递归继续
					break;
				flag = CompareObj(oA[k], oB[k], flag);
			}
		}
	}
	return flag;
};

function isObj(object) {
	return object && typeof (object) == 'object' && Object.prototype.toString.call(object).toLowerCase() == "[object object]";
}
function isArray(object) {
	return object && typeof (object) == 'object' && object.constructor == Array;
}
function getLength(object) {
	var count = 0;
	for (var i in object) count++;
	return count;
}
/**
 * 对比两个Obj并返回新对象与旧对象的差异属性及值
 * @param src
 * @param newer
 */
function diffObj(src, newer){
//	if(Object.keys(src).length != Object.keys(newer).length){
//        alert('eror');
//    }
	if(!isObj(src)||!isObj(newer)) return null;
	var diff=new Object();
	for (let x in newer) {
        if(src.hasOwnProperty(x)){
            if(src[x] != newer[x]){
                diff[x]=newer[x];
            }
        }
    }
	return diff;
}
$.extend({
	serializeObject:function(form) {
		var a, o, h, i, e;
		a = $(form).serializeArray();
		o = {};
		h = o.hasOwnProperty;
		for (i = 0; i < a.length; i++) {
			e = a[i];
			if (!h.call(o, e.name)) {
				o[e.name] = e.value;
			}
		}
		return o;
	}
});