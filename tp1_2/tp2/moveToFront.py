# https://en.wikipedia.org/wiki/Move-to-front_transform

import numpy as np
import re


# mtfwiki.py
# Instead of always transmitting an "original" dictionary, it is simpler to just agree on an initial set.
# Here we use the 256 possible values of a byte:
common_dictionary = list(range(256))

def encodeM(plain_text: str) -> list:
    # Change to bytes for 256.
    plain_text = plain_text.encode('utf-8')

    # Changing the common dictionary is a bad idea. Make a copy.
    dictionary = common_dictionary.copy()

    # Transformation
    compressed_text = []          # Regular array
    rank = 0

    # Read in each character
    for c in plain_text:
        rank = dictionary.index(c)    # Find the rank of the character in the dictionary [O(k)]
        compressed_text.append(rank)  # Update the encoded text

        # Update the dictionary [O(k)]
        dictionary.pop(rank)
        dictionary.insert(0, c)

    m = re.sub("( )+", " ", np.array2string(np.array(compressed_text))[1:-1])


    return m.replace("\n", "")            # Return the encoded text

def decodeM(compressed_data: str) -> str:
    compressed_text = compressed_data.split()
    dictionary = common_dictionary.copy()
    plain_text = []

    # Read in each rank in the encoded text
    for rank in compressed_text:
        # Read the character of that rank from the dictionary
        plain_text.append(dictionary[int(rank)])

        # Update the dictionary
        e = dictionary.pop(int(rank))
        dictionary.insert(0, e)

    return bytes(plain_text).decode('utf-8')  # Return original string