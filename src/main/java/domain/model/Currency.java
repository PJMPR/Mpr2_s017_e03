package domain.model;

public enum Currency {
    USD, CHF, PLN, JPN;
    
    public static Currency getByName(String enumName){
    	 for (Currency cur : Currency.values()) {
    		 if (cur.toString().equalsIgnoreCase(enumName)){
    			 return cur;
    		 }    	 
    	 }
    	 return null;
    }
}


