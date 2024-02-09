var LocalStorage = require("node-localstorage").LocalStorage,
  localStorage = new LocalStorage("./scratch");

const getParameters = async (msg) => {
  let testType = localStorage.getItem("testType");
  let testVersion = localStorage.getItem("testVersion");
  let pmEnv = localStorage.getItem("pmEnv");
  let baseURL = localStorage.getItem("baseURL");

  let command = "";
  let optionsMessage = "";
  let storageKey = "";
  let urlParam = "";

  try {
    // Get the message
    const message = msg.content;
    // Split the message
    console.log("message: " + JSON.stringify(msg));
    const splitMessage = message.split(" ");
    // Get the command
    command = splitMessage[1];
    command = command.trim();
    command = command.toUpperCase();

    // Check if command is a valid command
    if (command === "START") {
      optionsMessage = "Which test do you want to run?\nSMOKE  |  REGRESSION  |  TEST";
    } else if (command === "SMOKE" || command === "REGRESSION" || command === "TEST") {
      optionsMessage = "Which version do you want to test?\n22.40  |  21.50";
      storageKey = "testType";
    } else if (command === "22.40" || command === "21.50") {
      optionsMessage = "Which environment do you want to test?\nPROD  |  QA";
      storageKey = "testVersion";
    } else if (command === "PROD" || command === "QA") {
      optionsMessage = command === "PROD" ? "Production is currently not available." : "You have selected QA environment.";
      storageKey = "pmEnv";
    } else {
      await msg.channel.createMessage(
        "Invalid command. Please try again.\nPlease make sure you put a single space between mention and command.\n\nExample: @bot start"
      );
    }
    msg.channel.createMessage(optionsMessage);

    // Set the parameters
    command = command.toLowerCase();
    if (storageKey) {
      testType = storageKey === "testType" ? command : testType;
      testVersion = storageKey === "testVersion" ? command : testVersion;
      pmEnv = storageKey === "pmEnv" ? command : pmEnv;
      localStorage.setItem(storageKey, command);
    }
  } catch (err) {
    console.warn("error here: " + err);
    await msg.channel.createMessage(
      `Hi ${msg.author.username}\n I experienced an error while processing your request.\nPlease contact the Rap team for assistance.`
    );
  }

  // Set url parameters
  baseURL = "https://autotest2.app.qa.tsretail.co.za/";
  let tempEnv = pmEnv != null ? "autotest2" : pmEnv;
  console.log(`&test_type=${testType}&ts_version=${testVersion}&pm_environment=${tempEnv}`);
  urlParam = `&test_type=${testType}&ts_version=${testVersion}&pm_environment=${tempEnv}`;

  let startMessage = `
  ## Starting the ${testType} test.
  > **Test specifications**:
  > Test type: ${testType}
  > Test Environment: ${pmEnv}
  > Environment version: ${testVersion}
  > Base URL: ${baseURL}
  `;
  // startMessage = ''

  return { urlParam, startMessage };
};

const clearParameters = () => {
  localStorage.removeItem("testType");
  localStorage.removeItem("testVersion");
  localStorage.removeItem("pmEnv");
  localStorage.removeItem("baseURL");
};

exports.getParameters = getParameters;
exports.clearParameters = clearParameters;
