/* 

Problem: Check if re-reated sub-sequence is present in the string or not

Example: "XYBAXB"
Result: XB(XBXB)

Example: "XBXAXB"
Result: XB(XBXB), XX(XXX)

Example: "XYBYAXBY"
Result: XY(XYXY), XB(XBXB), YB(YBYB), YY(YYY), YBY(YBYBY)

Comments:
- Characters can be shared between the two repeating subsequences i.e: YY(YYY)
- (not self discovered) if elements have a frequency of 1, they should be immediately discarded from the array
    as they cannot be part of a repeating subsequence

Approach

- Naive (N^2):
    - currentLength = (Array.length - 1). Create a loop that decrements "currentLength" till (currentLength < 2)
    - on every iteration, it checks if the sub-sequences of that length are the same, if so it prints it.
        (could start at currentLength = 2 as well)

- Complex (its difficult for me to have come up with it unless I've encountered a similar problem before)

 */