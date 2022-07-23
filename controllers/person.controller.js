var PersonService = require('../services/person.service');
const { response } = require('../app');

exports.createPerson = async function(req, res, next) {
      
    try {
        let newPerson = await PersonService.createPerson(req);

        return res.status(200)
                .json({status: 200,
                data: newPerson,
                message: 'Successfully created Person'});
    } catch(error) {
        return res.status(422).send({
            success: false,
            message: error.message
        });
    }
    
}
    