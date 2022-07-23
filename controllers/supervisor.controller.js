var SupervisorService = require('../services/supervisor.service');
const { response } = require('../app');

exports.getSupervisors = async function(req, res, next) {
    var supervisors = await SupervisorService.getSupervisors();
    res.status(200)
        .json({status: 200,
                data: supervisors,
                message: 'Successfully Loaded Supervisors'});
}
    