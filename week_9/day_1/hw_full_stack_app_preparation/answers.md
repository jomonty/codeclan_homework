### Questions

1. What is responsible for defining the routes of the `games` resource?
helpers/create_router.js on the server, imported into server.js.

2. What do you notice about the folder structure?  Whats the client responsible for? Whats the server responsible for?
Server is responsible for holding a connection to the db, performing CRUD operations on the db, running a listener on a defined port locally, administering RESTful routes to allow an external application to interact with the db.

Client is responsible for requesting data from the server, holding it in state, capturing form data and utilising the API provided for the server to create a new game, utilising the API to request via the server the deletion of a game from the db, rendering all content to the user and rerendering on change.

3. What are the the responsibilities of server.js?
Maintain connection to database
Provide RESTful routes to /api/games
Listen on port 9000 for requests

4. What are the responsibilities of the `gamesRouter`?
Provide RESTful routes to /api/games


5. What process does the the client (front-end) use to communicate with the server?
Via an API, utilising GET, POST and DELETE HTTP methods

6. What optional second argument does the `fetch` method take? And what is it used for in this application? Hint: See [Using Fetch](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch) on the MDN docs
An init object with a number of options to vary from the default GET set up, such as changing the method to POST, specifying a request body, manually setting the header.

7. Which of the games API routes does the front-end application consume (i.e. make requests to)?
GET('/')
POST('/')
DELETE('/:id')

8. What are we using the [MongoDB Driver](http://mongodb.github.io/node-mongodb-native/) for?
Simplifying the process of making a connection to a mongoDB and CRUD operations performed.


## Extension

Why do we need to use [`ObjectId`](https://mongodb.github.io/node-mongodb-native/api-bson-generated/objectid.html) from the MongoDB driver?
Since items are not held in an ordered array in a collection (and even if they were, we might not know the order of the array), to find, update or delete a specific document we need to know the id that the db is using to reference the document.


Add to your diagram the dataflow for removing a game.
