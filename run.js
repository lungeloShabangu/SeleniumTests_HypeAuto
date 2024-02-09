const eris = require("eris");
//const { getParameters, clearParameters } = require("./dialog");
//const { startJob } = require("./sendRequest");
//const LocalStorage = require("node-localstorage").LocalStorage;
const fs = require("fs");

module.exports.runBot = async (isReport) => {
  // Create a local storage instance to store parameters
//  const localStorage = new LocalStorage("./scratch");
  const Constants = eris.Constants;
  
  // Create a Client instance with our bot token.
  bot = new eris.Client("MTIwMDM0NDUwMjA0OTcwNjAxNA.G3LOFm.AKWTP_XNR5Cooo3ePUY4xurtwfgCkuApGRDjq8", {
    autoreconnect: false,
  });

  // When the bot is connected and ready, log to console.
  bot.on("ready", () => {
    console.log("Bot connected and online");
    
  });
  bot.on("error", (err) => {
    console.error(err); // or your preferred logger
    // return res.status(500).json({ message: "Error occured while connecting bot", error: err });
  });

  // Every time a message is sent anywhere the bot is present,
  // this event will fire and we will check if the bot was mentioned.
  // If it was, the bot will attempt to respond with "Present".
  bot.on("messageCreate", async (msg) => {
    // Check if the bot was mentioned, with no message after it, return "Present"
    
    let parameters = "";const botWasMentioned = msg.mentions.find((mentionedUser) => mentionedUser.id === bot.user.id);

    if (botWasMentioned) {
      const subProcess = require('child_process')
      subProcess.exec('mvn test -Dtest=MainRunner', (err, stdout, stderr) => {
        if (err) {
          console.error(err)
          process.exit(1)
        } else {
          console.log(`The stdout Buffer from shell: ${stdout.toString()}`)
          console.log(`The stderr Buffer from shell: ${stderr.toString()}`)
        }
      })
    }
  });

  bot.on("error", (err) => {
    console.warn(err);
  });

  bot.connect();
};
