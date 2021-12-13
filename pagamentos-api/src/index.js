const express = require('express');

const app = express();

app.use(express.json());

app.get('/', (req, res) => {
  res.json({ message: 'Hello World' });
});

app.post('/payment/cinhospede', (req, res) => {

  if (Math.random() < 0.5) {
    res.json({
      status: 'success',
      message: `Payment Successful`
    })
  } else {
    res.json({
      status: 'error',
      message: `Payment Failed`
    })
  }
});

app.listen(3333);