package domain.model;

public enum Operation {

    income, outcome, transfer;

    public static Operation getByName(String enumName) {
        for (Operation operation : Operation.values()) {
            if (operation.toString().equalsIgnoreCase(enumName)) {
                return operation;
            }
        }
        return null;
    }
}