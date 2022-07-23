//var Person = require('../models/person.model');

exports.createPerson = async function(req) {
    let person = req.body;
    console.log(`Person to create ${JSON.stringify(req.body)}`);
}