--如果是用户对应的公司不在机构表中，需要先建机构
insert into ic_company (org_id, org_name) values ('org_id', '测试公司名称');
insert into ic_company (org_id, org_name) values ('group_administrator', '管理员组');


-- 新建测试用户
insert into ic_user
  (user_id,
   user_name,
   u_type,
   u_password,
   expired_date,
   create_date,
   private_key,
   public_key,
   pay_type,
   req_type,
   private_key_api,
   public_key_api,
   org_id)
values
  ( 'Test-User',
    '测试用户',
    '4',        --1用户只提供身份证信息 2用户:验证电商代码 3用户:验证电商代码单号  4用户:验证电商代码单号单据
    '123456',
    to_date('9999/12/31','yyyy/mm/dd'),
    sysdate,
    -- 用户密钥
    'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs3H1JXKundcadz5Jz66meF5Hw6vlX7bKJPAOpqRActwdSWGKTo5JbFg6RJHLPdmvG7z8PU4qmewof83eG13m3mkJcpBlICGA5nnfiVDo35F9yYBZou5iun3OcRsttgMN15mZC4D+y1c1ZAf5uYfFHqjwlYn20CbHmveyE4fjr5AgMBAAECgYBW3Auk2lIiHFJfQkXvU/aQpM+MWzKKfxamplhR6f+L4xa+xu+VZOHK2G1sQVmxN6EHFkFpVBgf8Lg7FKBzxX+DcGt3/07pML2sLK3JV8xZyRtXU14qLoGlpV169AXMD0PBVcKzcEmnDWeO06PBp/fzAyMklwLIMyFluK0luzBDSQJBANqie8IRFg2b6OIGHbYUSD9QkWDT7waZdW89aBVnNNehk2vUoa7nREO6BVcKwGZZQlnHwE53xW2IgBaErS5WXL8CQQCjAfNqnvvSlYjDpkRXYqQNg7nDOVjWaSjSvevJfdLAm05aBjzjPLitiOgptm9p0nRUuZBF35YdY4mkqi7Ru/5HAkBWCIxEoK6Z6lko4Bk+9ho79/tNK/iqEycYAAT+Lx+nHqjBTOnWxqChOgkx6EQvwj4O0EDHX/ArmwQ0WD9BtbBHAkEAi/h5310DGbFjjbTwzCScgCpTUcqleP81mbiRhiQv20nAvtbKY8nZPtHnoSHRi4m2cKYit40lJrk5ERc9OsV1swJAUZrtH0zmKkDptG5ZrtCw2Vg63Wskq0IrQhTfFgITdOmk88jWEWqdojpvYvzaJelXXPuG8qCn2MGJF6He9xHUrg==',
    -- 用户公钥
    'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNx9SVyrp3XGnc+Sc+upnheR8Or5V+2yiTwDqakQHLcHUlhik6OSWxYOkSRyz3Zrxu8/D1OKpnsKH/N3htd5t5pCXKQZSAhgOZ534lQ6N+RfcmAWaLuYrp9znEbLbYDDdeZmQuA/stXNWQH+bmHxR6o8JWJ9tAmx5r3shOH46+QIDAQAB',
    '2', -- 支付类型1预支付 2后支付 3免支付
    '2', -- 1直调realtime 2混合调用 mixed
    -- 平台密钥
    'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIR1Oqvc9BKDf+MIWcLuvUV4yTTTn4xyJpWOaSSSslv0IY+hhCGdl3XkCyffE+G/rnCLqUQlbxPNK/q78Hj+wXxZzUIoK6RYUjD+DogozDTls1BUPkyD49QAP+vcIaabbvVKoIT4QvdXrL9G2C7Bf2ox43/NrlI54/wT1xd1ZfwBAgMBAAECgYADkLQ3lAbtyKRUlBD2cj6d9BZWWavdt+TZ+a9S0LAEUZnlp89KqFc/URgLxrFeTi5/0QKJVwiaW9dnNE/Qseq7SDShJCDQ2hs3aqEe2eNShxNtHzbbOXetLq5YANwcshMfsbWUod7ckbv19PJQxIa8S4VorGMoS9lLit9M/l+60QJBAL29BXLlbxAzjjZwPzXL2ppEyv8Y1eqDQHPIdh7gofZY4GF/BpaT9NV+bqs0PM4y5Jr2c7KRtCC4oIxZcQno6ksCQQCytzmyFncI1do9YbK+cOi/1BRVJkU1sOGS68AooSe86bUB6EPUsiOCrzr/clqbtzblC8kWfgrLu2jbQCL77YNjAkAAvzfARgrz42AR8sss6QqJRPAPpQdijvW3/vgIExZQI/VuLNPXz+lM1dyVq/T5UtX3jjTSZSRyZIetRcTeJx6VAkEAiSKh6i7k3mnDEpDSaOIZJ4HkrEY2m3GEVooCpOqspICtPa5txlt/djtiSTwFnTFktTNq9ZB4VkcTuhIoBisGQwJBAKOBZpphkmx5eSDl6/dv3Oqw/m3/baa16GRNaThhdJRgBQBPbDRya0rfcZpos21Bsm5fdbFS5TWtv5jwZY7mZmc=',
    -- 平台公钥
    'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEdTqr3PQSg3/jCFnC7r1FeMk005+MciaVjmkkkrJb9CGPoYQhnZd15Asn3xPhv65wi6lEJW8TzSv6u/B4/sF8Wc1CKCukWFIw/g6IKMw05bNQVD5Mg+PUAD/r3CGmm271SqCE+EL3V6y/RtguwX9qMeN/za5SOeP8E9cXdWX8AQIDAQAB',
    'org_id'  -- 机构代码
    );

-- 新建用户
insert into ic_user
  (user_id,
   user_name,
   u_type,
   u_password,
   expired_date,
   create_date,
   private_key,
   public_key,
   pay_type,
   req_type,
   private_key_api,
   public_key_api,
   org_id)
values
  ( 'admin_idcs',
    '管理员用户',
    '1',        --1用户只提供身份证信息 2用户:验证电商代码 3用户:验证电商代码单号  4用户:验证电商代码单号单据
    'admin5846@idcs',
    to_date('9999/12/31','yyyy/mm/dd'),
    sysdate,
    -- 用户密钥
    'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs3H1JXKundcadz5Jz66meF5Hw6vlX7bKJPAOpqRActwdSWGKTo5JbFg6RJHLPdmvG7z8PU4qmewof83eG13m3mkJcpBlICGA5nnfiVDo35F9yYBZou5iun3OcRsttgMN15mZC4D+y1c1ZAf5uYfFHqjwlYn20CbHmveyE4fjr5AgMBAAECgYBW3Auk2lIiHFJfQkXvU/aQpM+MWzKKfxamplhR6f+L4xa+xu+VZOHK2G1sQVmxN6EHFkFpVBgf8Lg7FKBzxX+DcGt3/07pML2sLK3JV8xZyRtXU14qLoGlpV169AXMD0PBVcKzcEmnDWeO06PBp/fzAyMklwLIMyFluK0luzBDSQJBANqie8IRFg2b6OIGHbYUSD9QkWDT7waZdW89aBVnNNehk2vUoa7nREO6BVcKwGZZQlnHwE53xW2IgBaErS5WXL8CQQCjAfNqnvvSlYjDpkRXYqQNg7nDOVjWaSjSvevJfdLAm05aBjzjPLitiOgptm9p0nRUuZBF35YdY4mkqi7Ru/5HAkBWCIxEoK6Z6lko4Bk+9ho79/tNK/iqEycYAAT+Lx+nHqjBTOnWxqChOgkx6EQvwj4O0EDHX/ArmwQ0WD9BtbBHAkEAi/h5310DGbFjjbTwzCScgCpTUcqleP81mbiRhiQv20nAvtbKY8nZPtHnoSHRi4m2cKYit40lJrk5ERc9OsV1swJAUZrtH0zmKkDptG5ZrtCw2Vg63Wskq0IrQhTfFgITdOmk88jWEWqdojpvYvzaJelXXPuG8qCn2MGJF6He9xHUrg==',
    -- 用户公钥
    'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNx9SVyrp3XGnc+Sc+upnheR8Or5V+2yiTwDqakQHLcHUlhik6OSWxYOkSRyz3Zrxu8/D1OKpnsKH/N3htd5t5pCXKQZSAhgOZ534lQ6N+RfcmAWaLuYrp9znEbLbYDDdeZmQuA/stXNWQH+bmHxR6o8JWJ9tAmx5r3shOH46+QIDAQAB',
    '2', -- 支付类型1预支付 2后支付 3免支付
    '2', -- 1直调realtime 2混合调用 mixed
    -- 平台密钥
    'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIR1Oqvc9BKDf+MIWcLuvUV4yTTTn4xyJpWOaSSSslv0IY+hhCGdl3XkCyffE+G/rnCLqUQlbxPNK/q78Hj+wXxZzUIoK6RYUjD+DogozDTls1BUPkyD49QAP+vcIaabbvVKoIT4QvdXrL9G2C7Bf2ox43/NrlI54/wT1xd1ZfwBAgMBAAECgYADkLQ3lAbtyKRUlBD2cj6d9BZWWavdt+TZ+a9S0LAEUZnlp89KqFc/URgLxrFeTi5/0QKJVwiaW9dnNE/Qseq7SDShJCDQ2hs3aqEe2eNShxNtHzbbOXetLq5YANwcshMfsbWUod7ckbv19PJQxIa8S4VorGMoS9lLit9M/l+60QJBAL29BXLlbxAzjjZwPzXL2ppEyv8Y1eqDQHPIdh7gofZY4GF/BpaT9NV+bqs0PM4y5Jr2c7KRtCC4oIxZcQno6ksCQQCytzmyFncI1do9YbK+cOi/1BRVJkU1sOGS68AooSe86bUB6EPUsiOCrzr/clqbtzblC8kWfgrLu2jbQCL77YNjAkAAvzfARgrz42AR8sss6QqJRPAPpQdijvW3/vgIExZQI/VuLNPXz+lM1dyVq/T5UtX3jjTSZSRyZIetRcTeJx6VAkEAiSKh6i7k3mnDEpDSaOIZJ4HkrEY2m3GEVooCpOqspICtPa5txlt/djtiSTwFnTFktTNq9ZB4VkcTuhIoBisGQwJBAKOBZpphkmx5eSDl6/dv3Oqw/m3/baa16GRNaThhdJRgBQBPbDRya0rfcZpos21Bsm5fdbFS5TWtv5jwZY7mZmc=',
    -- 平台公钥
    'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEdTqr3PQSg3/jCFnC7r1FeMk005+MciaVjmkkkrJb9CGPoYQhnZd15Asn3xPhv65wi6lEJW8TzSv6u/B4/sF8Wc1CKCukWFIw/g6IKMw05bNQVD5Mg+PUAD/r3CGmm271SqCE+EL3V6y/RtguwX9qMeN/za5SOeP8E9cXdWX8AQIDAQAB',
    'group_administrator'  -- 机构代码
    );
	
--接口初始化
INSERT INTO IC_REFERS
  (SEQ_NO,
   R_URL,
   R_USER_KEY,
   R_TIME_OUT,
   R_WEIGHT,
   IS_OFF,
   R_DESCRIPTION,
   CLASS_NAME,
   R_NAME,
   R_ID)
VALUES
  (0,
   'NULL',
   'NULL',
   30,
   10,
   '1',
   '为测试用户提供测试功能',
   'com.blc.apps.idcs.api.remote2.TestApiServiceImpl',
   '测试API',
   'Api-test-local');
   
--初始化用户接口关联数据
insert into ic_user_refers
  (r_user_id, r_seq_no, r_weight, r_is_expired, r_is_off, r_description)
values
  ('Test-User', 0, 10, to_date('9999/12/30', 'yyyy/mm/dd'), 1, '测试用户');
  
commit;