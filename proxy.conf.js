const PROXY_CONFIG=[{
  context:["/java"],
  secure:false,
  pathRewrite:{
    "^/java":"http://127.0.0.1:8081",
    changeOrigin:true,
    logLevel:"debug",
  }
}]
module.exports=PROXY_CONFIG;

