'use babel';

const grpc = require('grpc');

var helloworld = grpc.load("backend/autocomplete-java-server/src/main/proto/helloworld.proto");
var client = new helloworld.helloworld.Greeter("localhost:8080",grpc.credentials.createInsecure());
var hello = { name : "Jarek"};
client.sayHello(hello, function(err, resp){
  if(err){
    console.log(err)
  } else{
    console.log(resp)
  }
} )
