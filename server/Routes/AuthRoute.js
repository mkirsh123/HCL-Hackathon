const { Signup, Login } = require("../Controllers/AuthController");
const { verifyToken } = require("../Middlewares/AuthMiddleware");
const router = require("express").Router();

router.post("/signup", Signup);
router.post("/login", Login);
router.get("/verify", verifyToken, (req, res) => {
  res.json({ success: true, user: req.user });
});

module.exports = router;
