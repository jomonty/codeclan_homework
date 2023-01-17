const express = require('express');
const ObjectID = require('mongodb').ObjectID;

const createRouter = function (collection) {

  const router = express.Router();

  router.get('/', (req, res) => {
    collection
      .find()
      .toArray()
      .then((docs) => res.json(docs))
      .catch((err) => {
        console.error(err);
        res.status(500);
        res.json({ status: 500, error: err });
      });
  });

  router.get('/:id', (req, res) => {
    const id = req.params.id;
    collection
      .findOne({ _id: ObjectID(id) })
      .then((doc) => res.json(doc))
      .catch((err) => {
        console.error(err);
        res.status(500);
        res.json({ status: 500, error: err });
      });
  });

  router.post('/', (req, res) => {
    const newSighting = req.body;
    collection
      .insertOne(newSighting)
      .then(dbRes => res.json(dbRes.ops[0]))
      .catch(error => {
        console.error(error);
        res.status(500);
        res.json({ status: 500, error: error })
      })
  })

  router.delete('/:id', (req, res) => {
    const id = req.params.id;
    collection
      .deleteOne({ _id: ObjectID(id) })
      .then(dbRes => res.json(dbRes))
      .catch(error => {
        console.error(error);
        res.status(500);
        res.json({ status: 500, error: error });
      })
  })

  return router;
};

module.exports = createRouter;
