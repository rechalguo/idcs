$.extend({
    StandardPost:function(url,args, target){
    	var blank='';
    	if(target==='_blank'){blank="target='_blank'";}
        var form = $("<form method='post' "+blank+"></form>"),
            input;
        form.attr({"action":url});
        $.each(args,function(key,value){
            input = $("<input type='hidden'>");
            input.attr({"name":key});
            input.val(value);
            form.append(input);
        });
        //$(document.body).append(form);
        form.appendTo('body').submit().remove();
    }
});
$.extend({
    DonwloadFilePost:function(url,args){
    	var form = $("<form></form>").attr("action", url).attr("method", "post");
        form.append($("<input></input>").attr("type", "hidden"));
        $.each(args,function(key,value){
            input = $("<input type='hidden'>");
            input.attr({"name":key});
            input.val(value);
            form.append(input);
        });
        form.appendTo('body').submit().remove();
    }
});
