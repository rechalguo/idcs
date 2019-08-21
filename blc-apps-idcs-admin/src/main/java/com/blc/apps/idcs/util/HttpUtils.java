package com.blc.apps.idcs.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	private static Logger logger=LoggerFactory.getLogger(HttpUtils.class);
	private PoolingHttpClientConnectionManager cm=null;
	
	private HttpUtils() {
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(200);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		// Increase max connections for localhost:80 to 50
		//HttpHost localhost = new HttpHost("locahost", 80);
		//cm.setMaxPerRoute(new HttpRoute(localhost), 50);
	}
	
	//单例（内部类）
	private static class HttpClientFactoryInner{
		private static HttpUtils httpClientFactory = new HttpUtils();
	}
	public static HttpUtils getInstance() {
		return HttpClientFactoryInner.httpClientFactory;
	}
	
	/**
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 */
	public String postFormRequest(String url, Map<String,String> parameters, Map<String,String> headers) throws Exception {
		long start=System.currentTimeMillis();
		CloseableHttpClient client=HttpClients.custom().setConnectionManager(cm).build();
		CloseableHttpResponse response=null;
		HttpEntity entity=null;
		String result=null;
		int status=200;
		try {
			HttpPost post = new HttpPost(url);
			
			if(headers!=null){
				for(String h:headers.keySet()) {
					post.setHeader(h, headers.get(h));
				}
			}
			//request.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			UrlEncodedFormEntity form = null;
			if(parameters!=null) {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>(parameters.size());
				for(Map.Entry<String, String> e : parameters.entrySet()) {
					formparams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
				}
				form = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			} else {
				form = new UrlEncodedFormEntity(new ArrayList<NameValuePair>(0), Consts.UTF_8);
			}
			post.setEntity(form);
			response=client.execute(post);
			status = response.getStatusLine().getStatusCode();
			if(200==status&&response!=null) {
				entity = response.getEntity();
				return this.readEntityToString(entity.getContent());
			}
		}catch(Exception e) {
			throw e;
		} finally {
			if(response!=null) response.close();
			logger.debug("# Request Complete [ "+(System.currentTimeMillis()-start)+" ] status: "+status);
		}
		return result;
	}
	
	/**
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 */
	public String postBodyRequest(String url, String body, Map<String,String> headers) throws Exception {
		long start=System.currentTimeMillis();
		CloseableHttpClient client=HttpClients.custom().setConnectionManager(cm).build();
		CloseableHttpResponse response=null;
		HttpEntity entity=null;
		String result=null;
		int status=200;
		try {
			HttpPost post = new HttpPost(url);
			if(headers!=null){
				for(String h:headers.keySet()) {
					post.setHeader(h, headers.get(h));
				}
			}
			//request.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			if(body==null) body = "";
			StringEntity e = new StringEntity(body, Consts.UTF_8);
			e.setContentEncoding(Consts.UTF_8.toString());
			post.setEntity(e);
			response=client.execute(post);
			status = response.getStatusLine().getStatusCode();
			if(200==status&&response!=null) {
				entity = response.getEntity();
				return this.readEntityToString(entity.getContent());
			}
		}catch(Exception e) {
			throw e;
		} finally {
			if(response!=null) response.close();
			logger.debug("# Request Complete [ "+(System.currentTimeMillis()-start)+" ] status: "+status);
		}
		return result;
	}
	
	/**
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 */
	public String get(String url, Map<String,String> parameters, Map<String,String> headers) throws Exception {
		long start=System.currentTimeMillis();
		CloseableHttpClient client=HttpClients.custom().setConnectionManager(cm).build();
		CloseableHttpResponse response=null;
		HttpEntity entity=null;
		String result=null;
		int status=200;
		try {
			
			//request.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			if(parameters!=null) {
				StringBuilder queryStr=new StringBuilder("?");
				for(Map.Entry<String, String> e : parameters.entrySet()) {
					queryStr.append(e.getKey()).append("=").append(e.getValue()).append("&");
				}
				url=url.concat(queryStr.toString());
			}
			
			HttpGet get = new HttpGet(url);
			if(headers!=null){
				for(String h:headers.keySet()) {
					get.setHeader(h, headers.get(h));
				}
			}
			response=client.execute(get);
			status = response.getStatusLine().getStatusCode();
			if(200==status&&response!=null) {
				entity = response.getEntity();
				return this.readEntityToString(entity.getContent());
			}
		}catch(Exception e) {
			throw e;
		} finally {
			if(response!=null) response.close();
			logger.debug("# Request Complete [ "+(System.currentTimeMillis()-start)+" ] status: "+status);
		}
		return result;
	}
	
	
	
	
	private String readEntityToString(InputStream in) {
		if(in==null) return null;
		ByteArrayOutputStream bos=null;
		try {
			bos=new ByteArrayOutputStream();
			byte[] cnt=new byte[1024];
			int len=-1;
			while((len=in.read(cnt))!=-1) {
				bos.write(cnt,0,len);
			}
			return bos.toString("utf-8");
		} catch(Exception e) {
			logger.error("## Read HttpEntity Error.", e);
		} finally {
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(bos!=null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
}
