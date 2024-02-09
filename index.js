const express = require('express')
const { runBot } = require('./run')
//const { runBatchFile } = require('./batchFile')
const app = express()
const port = 3001
 

const subProcess = require('child_process')


 runBot()

app.get('/', (req, res) => {
    runBot()
  res.send('Hello World!')
})
 
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})