//var Supervisor = require('../models/supervisor.model');
const { default: axios } = require('axios');
const jsdom = require('jsdom')
const dom = new jsdom.JSDOM("")

const $ = require( "jquery" )(dom.window);

exports.getSupervisors = async function() {
    let toReturn = [];
    return axios.get('https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers').then((response) => {
        let supervisors = response.data;

        // get only non-numeric jury
        let nonNumericJurySupervisors = supervisors.filter((s) => {
            return !$.isNumeric(s.jurisdiction)
        });


        // order by juri then last and firstName
        nonNumericJurySupervisors.sort((a,b)=> (a.jurisdiction.localeCompare(b.jurisdiction) 
                                                || a.lastName.localeCompare(b.lastName)
                                                || a.firstName.localeCompare(b.firstName)));

        toReturn = nonNumericJurySupervisors.map((s)=>{ return s.jurisdiction + " - " + s.lastName + ", " + s.firstName; })
        return toReturn;
    });
}