from pillow import Image


def remove_white(input_path, output_path):
    img = Image.open(input_path)

    img = img.convert("RGBA")

    data = img.getdata()

    new_data = []
    for item in data:
        if item[:3] == (255, 255, 255):
            new_data.append((255, 255, 255, 0))
        else:
            new_data.append(item)

    img.putdata(new_data)

    img.save(output_path, "PNG")


# Example usage
remove_white(
    "/Users/zgj/Desktop/Screen Shot 2023-11-15 at 14.57.50.png",
    "/Users/zgj/Desktop/onetile.png",
)
