import json
import os
saplings=[
      "sacred_oak_sapling",
      "mega_oak_sapling",
      "massive_oak_sapling",
      "sacred_birch_sapling",
      "mega_birch_sapling",
      "massive_birch_sapling",
      "sacred_spruce_sapling",
      "mega_spruce_sapling",
      "massive_spruce_sapling",
      "sacred_jungle_sapling",
      "mega_jungle_sapling",
      "massive_jungle_sapling",
      "sacred_acacia_sapling",
      "mega_acacia_sapling",
      "massive_acacia_sapling",
      "sacred_dark_oak_sapling",
      "mega_dark_oak_sapling",
      "massive_dark_oak_sapling",
      "sacred_crimson_fungus",
      "mega_crimson_fungus",
      "massive_crimson_fungus",
      "sacred_warped_fungus",
      "mega_warped_fungus",
      "massive_warped_fungus"
    ]
folder='src/main/resources/data/sacred_trees/loot_tables/blocks'
for sapling in saplings:
    filename=os.path.join(folder,sapling+".json")
    with open(filename,"w") as f:
        json.dump({
    "type": "minecraft:block",
    "pools": [
      {
        "rolls": 1,
        "entries": [
          {
            "type": "minecraft:item",
            "name": f"sacred_trees:{sapling}"
          }
        ],
        "conditions": [
          {
            "condition": "minecraft:survives_explosion"
          }
        ]
      }
    ]
  },fp=f,indent=2)
        print(filename)
