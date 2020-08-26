# AlgorithmTestPT

##  How to execute : 
1. Import project using AndroidStudio
2. Run all the test (Windows: Ctrl + Shift + F10)

## Test code located in :
\app\src\test\java\com\ittyo\algorithmtestpt

## Memory and Complexity Analysis
### A. Load and Store Problems :
#### 1. Time complexity analysis

##### Store operation :

Because we iterate over elements of map array and iterate over entry in map contained in every array, so the complexity analysis is O(n\*m), when n is length of array and m is maximum size of map entry contained in array.

##### Load operation :

- Because to load we need to parse the text (iterate over character inside the text)
- We need iterate over number of elements in array (result of split of \n)
- We need iterate over number of entry in map (result of split of ;)

So the complexity analysis is O(l\*n\*m), with l is text length, n is number of new line (or element in map array), and m is max number entry of map contained in array.

#### 2. Memory complexity analysis :

##### Store operation :

Because the text length is affected by :
- Number of elements in array
- Number of entry in map
- Number of character in key and value

So the complexity analysis is O(n\*m\*c), where n is number of element in array, m is max number of entry in map, c is max number of character in key and value

##### Load Operation :

Because we need create array object that contains map, and each map contain entry, and each entry contain key and value, so the complexity analysis is O(n\*m\*c), where n is number of element in array, m is max number of entry in map, c is max number of character in key and value


### C. Retail Problems :

#### 1. Time complexity analysis :

Because to calculate payable amount we do iteration on purchased items, so the complexity is : O(n), with n is the number of purchased item.

#### 2. Memory complexity analysis :

I think every operation to calculate payable amount use mutating variable, so the complexity is constant : O(1)
