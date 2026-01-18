require("dotenv").config();
const jwt = require("jsonwebtoken");

module.exports.createSecretToken = (payload) => {
  return jwt.sign(payload, process.env.TOKEN_KEY, {
    expiresIn: 3 * 24 * 60 * 60,
  });
};
