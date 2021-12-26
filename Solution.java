class Solution {
    private static final long MAX_SUFFIX = 1000000000000L;
    private static final int MAX_PREFIX = 100000;
    
    public String abbreviateProduct(int left, int right) {
        long product = 1;
        int trailingZeros = 0;
        double prefix = 1.0;
        
        for (int num = left; num <= right; num++) {
            product *= num;
            while (product % 10 == 0) {
                product /= 10;
                trailingZeros++;
            }
            
            if (product >= MAX_SUFFIX) {
                product %= MAX_SUFFIX;
            }
            
            prefix *= num;
            
            while (prefix >= MAX_PREFIX) {
                prefix /= 10;
            }
        }
        return buildAbbreviation(prefix, product, trailingZeros);
    }
    
    private String buildAbbreviation(double prefix, long product, int trailingZeros) {
        String suffix = String.valueOf(product);
        if (suffix.length() > 10) {
            suffix = (int)prefix + "..." + suffix.substring(suffix.length() - 5);
        }
        
        return String.format("%se%d", suffix, trailingZeros);
    }
    