class Solution {
public:
    bool halvesAreAlike(string s) {
        int n = s.length();
        int mid = n / 2;
        
        int count = 0;
        
        for (int i = 0; i < mid; i++) {
            if (isVowel(s[i])) count++;
            if (isVowel(s[i + mid])) count--;
        }
        
        return count == 0;
    }
    
private:
    bool isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
};
