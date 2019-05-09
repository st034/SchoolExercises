const request = require('request');
handler();
function handler (){
    var options = {
        url: 'http://www.energyhive.com/mobile_proxy/getCurrentValuesSummary?token=rIA3cQ-cMI5NMxnptHmlZX98bu4yVaRg',
        method: 'GET',
        auth: {
            user: 'dudisi@live.it',
            password: 'Bindura'
        }
    };
    request(options, (error, response, body) => {
        console.log(body);
    });
}