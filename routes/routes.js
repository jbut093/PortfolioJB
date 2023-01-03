// Setup express router
const express = require("express");
const router = express.Router();

// Route handlers

router.get("/", function (req, res) {

    res.locals.name ="Home",
     
       
       res.render("home", {display:true}); 

});

router.get("/java", function (req, res) {

    res.locals.name ="Java Projects"; 
             
    res.render("java"); 

});
 
router.get("/webDev", function (req, res) {

    res.locals.name ="Web Development"; 
    res.render("webDev"); 

});

router.get("/data", function (req, res) {

    res.locals.name ="Data analysis projects"; 
    res.render("data"); 

});

router.get("/cv", function (req, res) {

    res.locals.name ="CV"; 
    res.render("cv"); 

});

router.get("/about", function (req, res) {

    res.locals.name ="About"; 
    res.render("about"); 

});



module.exports = router;