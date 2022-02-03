Assume you have coins
/*c1=1, c2, ... cn
V : what coins to be used to get to that V
Minimum number of coins to use.





1,2,5,11,7

1,2,3,5,7,11, 20, 21, 22


MAX(29,V)
1 3 6 11 18 29
1 1 1  1  1  1

1+2

1 : 1 
2 : 2
3 : 1 
4 : 2
5 : 3


6 : 1 * 6Coin


10/7 = 3
Approach1
// Iterate Array and Put it into a TreeSet
// Iterate over treeset, to out the max value coin before the actual sum
// Take Mod-> Remaining value (check in treeset if present)
// else try with previous big number
*/




private static int minimumChangeForValue(int[] coinsArray,int sumToFind){
    
    int maxValueCoin = findMaxValueCoin(coinsArray);
    
    int minValue = Math.min(maxValueCoin,sumToFind);
    
    int[] arrayWithMinimumCost = new int[minValue+1];
    
    arrayWithMinimumCost = setCoinValuesToOne(coinsArray,arrayWithMinimumCost);
    
    findMinCostForEachCoin(arrayWithMinimumCost);
    
    return arrayWithMinimumCost[sumToFind];
    
}




/*
1. Any number of coins ? If we have infinite coins ?
2. Return : All possible solutions ?
3. Are they ordered ?
4. Can it be any integer ?
*/
