package example.org;

public class MsgCostReader implements IElementReader<Double> {
    private final ICustomPrompt prompt;

    public MsgCostReader(ICustomPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public Double read() {
        return prompt.getDouble("Enter the item price (or type QUIT to finish): ");
    }
}

