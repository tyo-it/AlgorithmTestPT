# AlgorithmTestPT

##  How to execute : 
1. Import project using AndroidStudio
2. Run all the test (Windows: Ctrl + Shift + F10)

## Test code located in :
\app\src\test\java\com\ittyo\algorithmtestpt

## Memory and Complexity Analysis
### A. Load and Store Problems :
#### 1. Time complexity analysis

##### Store operation : O(n\*m)

* n = length of array ( because we iterate over elements of map array )
* m = maximum size of map entry contained in array ( because we iterate over entry in every map contained in array)

##### Load operation : O(l\*n\*m)

* l = text length (we need to parse the text so it means that we need to iterate over character inside the text)
* n = number of new line separator (or the number of elements in array)
* m = maximum number of entry separator ';' (or maximum entry size of map contained in array)


#### 2. Memory complexity analysis :

##### Store operation : O(n\*m\*c)

* n = number of elements in array
* m = maximum number of entry in map
* c = max number of character in key and value

##### Load Operation : O(n\*m\*c)

Because we need create array object that contains map, and each map contain entry, and each entry contain key and value :

* n = number of new line separator (or the number of elements in array)
* m = maximum number of entry separator ';' (or maximum entry size of map contained in array)
* c = maximum number of character in key and value


### C. Retail Problems :

#### 1. Time complexity analysis : O(n)

* n = the number of purchased item (because to calculate payable amount we do iteration over purchased items)

#### 2. Memory complexity analysis : O (1)

* I think every operation to calculate payable amount use mutating variable, so the complexity is constant : O(1)
