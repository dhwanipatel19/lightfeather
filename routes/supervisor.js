var express = require('express');
var router = express.Router();

var supervisor_controller = require('../controllers/supervisor.controller');

router.get('/', supervisor_controller.getSupervisors); // Numberic juri supervisors "juri - lastName, firstName"

module.exports = router;
