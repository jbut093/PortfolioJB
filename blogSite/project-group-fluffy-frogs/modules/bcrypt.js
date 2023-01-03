// Require bcrypt
// And set saltRounds to 10

const bcrypt = require('bcrypt');
const saltRounds = 10;

// TODO Encrypt password
// Async function to hash password, take a password as a parameter
// Await hash function in bcrypt
// Return the hashed password

async function hashPassword(password){
    const hashedPassword = await bcrypt.hash(password, saltRounds);

    return hashedPassword
}

// TODO Compare password
// Async function to compare password, take a password and hash as a parameter
// Await bcrypt compare function
// Return the result

async function comparePassword(password, hashedPassword){
    return await bcrypt.compare(password, hashedPassword)
}

module.exports = {
    hashPassword,
    comparePassword
};