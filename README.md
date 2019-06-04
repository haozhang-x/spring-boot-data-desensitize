# spring-boot-desensitize
Data Desensitize


# Desensitize Data Like This
 
"code": 200,
"msg": "OK",
"data": [
{
"username": "us*ser0",
"idCard": "00***********0000",
"password": "******",
"phone": "18****0000",
"birthday": "2019-06-04 11:12:19 下午"
},
{
"username": "us*ser1",
"idCard": "00***********0001",
"password": "******",
"phone": "18****0001",
"birthday": "2019-06-04 11:12:19 下午"
},
{
"username": "us*ser2",
"idCard": "00***********0002",
"password": "******",
"phone": "18****0002",
"birthday": "2019-06-04 11:12:19 下午"
}
]

# Usage
Use annotation @Sensitive
SensitiveUtil.java to make your fields own logic.
SensitiveType.java definition type.

