(function(){

var app = angular.module("DonutApp");
app.service("loginService", [function(){
   
    this.authorized=false;
    
    var user={
        "username":"",
        "password":""
    };
      
    
    this.setUsername=(uname)=>user.username=uname;
    this.setPassword=(pword)=>user.password=pword;
    
    
    var userList =[
       {
           "username":"Emily",
           "password":"4444"
       },{
           "username":"rat",
           "password":"456"
       },{
           "username":"sam",
           "password":"frodo"
       }
        
    ];
    
    this.validateUser=()=>{
        for(let i=0; i<userList.length;i++){
            if(userList[i].username===user.username && userList[i].password===user.password){
                this.authorized=true;
               
                break;
            }
       }       
      return this.authorized; 
    };
    
}]);
})();