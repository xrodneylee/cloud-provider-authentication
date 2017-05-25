[![Build Status](https://travis-ci.org/xrodneylee/cloud-provider-authentication.svg?branch=master)](https://travis-ci.org/xrodneylee/cloud-provider-authentication)

## Usage

### Azure
```
credential = new AzureCredential.Builder()
        .setClientId("clientId")
        .setTenant("tenant")
        .setClientSecret("clientSecret")
        .build();
		
response = credential.invoke();
```
### Linode
```
credential = new LinodeCredential.Builder()
        .setUsername("username")
        .setPassword("password")
        .build();
		
resposne = credential.invoke();
```