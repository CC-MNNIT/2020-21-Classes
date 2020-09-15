var express = require('express');
var path = require('path');
var app = express(); 
//Comment
app.listen(8000);
app.set('view engine','ejs');
//Middleware
//app.use('/myStaticFiles',express.static('static'));
app.use(express.static(path.join(__dirname, 'static')));
// req -- middleware -- res
app.get('/', function(request,response){
    response.send("Hello World 21!");
});

app.get('/home',function(req,res){
    res.render('home.ejs', { name : "Mohit" , value : "value"} );
});

app.get('/about',function(req,res){
    res.send("About page")
})

app.get('/contact',function(req,res){
    res.send("Contact page")
})
