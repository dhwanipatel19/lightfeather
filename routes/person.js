var express = require('express');
var router = express.Router();

var person_controller = require('../controllers/person.controller');
const { body, validationResult } = require('express-validator');

router.post('/', body('firstName').isLength({min:1}),
                body('lastName').isLength({min:1}), 
                body('supervisor').isLength({min:1}),
                (req, res) => {
   const errors = validationResult(req);
   if(!errors.isEmpty()) {
    return res.status(400).json({ errors: errors.array() });
   }

   person_controller.createPerson(req, res); 
})

module.exports = router;
