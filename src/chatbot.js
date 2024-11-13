require('dotenv').config();
const { Configuration, OpenAIApi } = require('openai');

// Load the API key from the environment variable
const apiKey = process.env.OPENAI_API_KEY;

// Print the API key to verify it's loaded correctly (remove this line in production)
console.log(`Loaded API key: ${apiKey}`);

const configuration = new Configuration({
  apiKey: apiKey,
});

const openai = new OpenAIApi(configuration);

class Chat {
  constructor(initialInstruction) {
    this.instruction = initialInstruction;
    this.messages = [
      { role: "system", content: this.instruction }
    ];
  }

  addMessage(role, content) {
    this.messages.push({ role: role, content: content });
  }

  async response(userInput) {
    // Define the character limit
    const charLimit = 90;

    // Check if the user input exceeds the character limit
    if (userInput.length > charLimit) {
      return `Error: Your input exceeds the ${charLimit} character limit. Please shorten your message.`;
    }

    // Add user input to the conversation history
    this.addMessage("user", userInput);

    // Make a request to the OpenAI API
    try {
      const response = await openai.createChatCompletion({
        model: "gpt-3.5-turbo-16k",
        messages: this.messages
      });

      // Extract the response content
      const assistantMessage = response.data.choices[0].message.content;

      // Add the assistant's response to the conversation history
      this.addMessage("assistant", assistantMessage);

      return assistantMessage;
    } catch (error) {
      console.error("Error with OpenAI API request:", error);
      return "There was an error processing your request. Please try again later.";
    }
  }
}

// Example usage:
(async () => {
  const chat = new Chat("You are a helpful assistant that answers questions about the app neptune, neptune is a ....");
  const response = await chat.response("Hello, how can you help me?");
  console.log(response);
})();
