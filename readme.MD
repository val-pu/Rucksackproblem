# An optimized version of the Rucksackproblem

$w_i = {6,2,3,1,1,5}$ \
$v_i = {7,8,3,1,2,4}$

| Item No / Max weight |  0  |  1  |  2  |   3   |   4   |  5  |  6  |  7  |  8  |
|:--------------------:|:---:|:---:|:---:|:-----:|:-----:|:---:|:---:|:---:|:---:|
|        Item 0        |  0  |  0  |  0  |   0   |   0   |  0  |  0  |  0  |  0  |
|        Item 1        |  0  |  0  |  0  |   0   |   0   |  0  |  7  |  7  |  7  |
|        Item 2        |  0  |  0  |  8  |   8   |   8   |  8  |  8  |  8  | 15  |
|        Item 3        |  0  |  0  |  0  |   3   |   3   | 11  | 11  | 11  | 11  |
|        Item 4        |  0  |  1  |  1  | **x** | **y** | ..  | ..  | ..  | ..  |
|        Item 5        |  0  | ..  | ..  |  ..   |  ..   | ..  | ..  | ..  | ..  |
|        Item 6        |  0  | ..  | ..  |  ..   |  ..   | ..  | ..  | ..  | ..  |

`x` will be calculated by the function: 
```
current_item    // Item referenced in the left most entry of the row
current_index
current_weight  // Weight referenced in the top most entry of the column

if(max_weight >= current_item.weight) {
    x+= current_item.weight
} then {
    x+=max(where item n with n < current_index and max_weight < current_weight)
}
```
thus x will be:
'1+8'

# Source
https://de.wikiversity.org/wiki/Kurs:Algorithmen_und_Datenstrukturen/Vorlesung/Beispiel:Rucksackproblem_dynamisch (7.4.2023)