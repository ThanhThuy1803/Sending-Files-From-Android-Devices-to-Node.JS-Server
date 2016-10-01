var express = require("express");
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io").listen(server);
var fs = require("fs");
server.listen(process.env.PORT || 3000);

var arrayImage = new Array();
var arraySound = new Array();

fs.readdir("images/", function(err, files) {
    if (err) {
        return;
    }
    files.forEach(function(f) {
       arrayImage.push("images/"+f);
    });
});

fs.readdir("sounds/", function(err, files) {
    if (err) {
        return;
    }
    files.forEach(function(f) {
       arraySound.push("sounds/"+f);
    });
});

io.sockets.on('connection', function (socket) {

  console.log("NOTICE: NEW USER CONNECTED!" + socket.id);

  socket.on('CLIENT_SEND_IMAGE', function (data) {
        console.log("SERVER SAVED A NEW IMAGE");
        var filename = getFilenameImage(socket.id);
        arrayImage.push(filename);
        fs.writeFile(filename, data);
  });
  socket.on('CLIENT_SEND_SOUND', function (data) {
              console.log("SERVER SAVED NEW SOUND");
              var filename = getFilenameSound(socket.id);
              arraySound.push(filename);
              fs.writeFile(filename, data);
    });

  socket.on('CLIENT_SEND_REQUEST', function(data){
        var filename = getRandomFile(arrayImage);
        fs.readFile(filename, function(err, data){
            if(!err){
                io.emit('SERVER_SEND_IMAGE', data);
                console.log("SEND TO CLIENT A FILE: "+filename);
            }else{
                console.log('THAT BAI: ' + filename);
            }
        });
  });

  socket.on('CLIENT_SEND_REQUEST_SOUND', function(data){
          var filename = getRandomFile(arraySound);
          fs.readFile(filename, function(err, data){
                      if(!err){
                          io.emit('SERVER_SEND_SOUND', data);
                          console.log("SEND TO CLIENT A FILE: "+filename);
                      }else{
                          console.log('THAT BAI: ' + filename);
                      }
                  });
    });



});
function getFilenameImage(id){
    return "images/" + id.substring(2) + getMilis() + ".png";
}

function getFilenameSound(id){
    return "sounds/" + id.substring(2) + getMilis() + ".3gpp";
}

function getMilis(){
    var date = new Date();
    var milis = date.getTime();
    return milis;
}

function getRandomFile(array){
    return array[Math.floor(Math.random()*array.length)];
}
