package zadanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {
    private List<Block> blockList;

    public Wall(List<Block> blockList) {
        this.blockList = blockList;
    }

    @Override
    public String getColor(Block block) {
        return block.getColor();
    }

    @Override
    public String getMaterial(Block block) {
        return block.getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return new ArrayList<>(blockList);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blockList.stream()
                .filter(s1 -> s1.getColor().equalsIgnoreCase(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blockList.stream()
                .filter(s1 -> s1.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        int count = 0;
        for (Block b : blockList) {
            if (b != null)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Block> blocks = List.of(
                new Block("red", "metal"),
                new Block("blue", "metal"),
                new Block("green", "metal"),
                new Block("red", "stone"),
                new Block("blue", "stone"),
                new Block("green", "stone"),
                new Block("red", "wood"),
                new Block("blue", "wood"),
                new Block("green", "wood")
        );
        Wall wall = new Wall(blocks);
        List<Block> blocks1 = wall.getBlocks();

        Optional<Block> any = wall.findBlockByColor("red");


        List<Block> blocks2 = wall.findBlocksByMaterial("stone");
        Map<String, String> mappedBlock2 = blocks2.stream()
                .collect(Collectors.toMap(Block::getColor, Block::getMaterial));
        System.out.println(mappedBlock2);

        System.out.println(wall.count());
    }
}
