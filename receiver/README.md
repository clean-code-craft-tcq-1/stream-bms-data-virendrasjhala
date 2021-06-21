# Streaming BMS Data

This project is about sending BMS data.

## Decomposition

At a top level, the program runs in two processes - the sender and the receiver.

The Sender is responsible for sending BMS data.
The Receiver processes the data.

The Sender sends data to the Receiver using [console redirection and pipes](https://ss64.com/nt/syntax-redirection.html).

### The Sender

- sends two Battery / Charging parameters
- sends these parameters in a stream (keeps sending automatically till the user stops)
- can either generate random values for the parameters, or read from a file
- uses console output to communicate the parameters.

### Output format 
- sends two battery parameter values 
- Format => <value_1>, <value_2>
			<value_3>,<value_4>
			...
			<value_n1>,<value_n2>

### Test cases 
Test cases are available in 


## Quality Parameters

Duplication : Not more than 3 lines
Complexity  : Maximum 3
Coverage 	: Part of coverage report


