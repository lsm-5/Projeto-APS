const express = require('express');

const app = express();

app.use(express.json());

app.get('/', (req, res) => {
  res.json({ message: 'Hello World' });
});

app.post('/payment/cinhospede', (req, res) => {
  const user = req.body['userName']
  const roomId = req.body['roomId']
  const payment = req.body['payment']
  const type = req.body['payment']['type']

  if (Math.random() < 0.5) {
    res.json({
      user: user,
      status: 'success',
      message: `Payment Successful with ${type}`
    })
  } else {
    res.json({
      user: user,
      status: 'error',
      message: `Payment Failed with ${type}`
    })
  }
});

app.listen(3333);