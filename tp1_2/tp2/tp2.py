#RLE: DDDD -> 4D; 1112222 -> 3 - 1, 4 - 2;
#alteracao estatistica, move-to-front
#
import numpy as np
import os
import func_aux as fa
import RLE as rl
import LZW as l
import burrows_wheeler as bw
import moveToFront as mtf
import huffman as hf
'''
RLE:

    
'''

def writeEntropy(source, forAlf, string):
    with open("entropy.txt", "a") as f:
        f.write("Entropy of "+string+" "+str(fa.entropia(source, fa.getAlpha(forAlf))))
        f.write("\n")

# Perform Run–length encoding (RLE) data compression algorithm on string `str`

            

def main():
    with open("entropy.txt", "w"):
        pass
    filesIn = ["dataset/bible.txt", "dataset/finance.csv", "dataset/jquery-3.6.0.js", "dataset/random.txt"]
    filesOut = ["dataset/bible1.txt", "dataset/finance1.csv", "dataset/jquery-3.6.0.1.js", "dataset/random1.txt"]

    methods = ["RUN_LENGTH_ENCODING"]
    for i in range(1):
        for n in range(len(methods)):
            fInput = filesIn[i]
            fOutput = filesOut[i]
            input = fa.readText(fInput)

            inString = fa.readText(fInput)
            asArrayIn = np.array(list(inString))

            hold = hf.Huffman_Enconding(inString)
            s = hold[0]
            asArrayOut = np.array(list(s))
            tree = hold[1]
            with open(fOutput, "w") as f:
                f.write(s)
            
            print(fa.entropia(asArrayIn, fa.getAlpha(asArrayIn)))
            print(fa.entropia(asArrayOut, fa.getAlpha(asArrayOut)))

            decoded = hf.Huffman_Decoding(s, tree)
            asArrayDecoded = np.array(list(decoded))

            with open("decoded.txt", "w") as f1:
                f1.write(decoded)

            print(fa.entropia(asArrayDecoded, fa.getAlpha(asArrayDecoded)))

            


if __name__ == '__main__':
    main()
    
    
#METHODS JUNCTION:
"""
RLE
LZW
BURROWS
MTF
HUFFMAN

BURROWS+RLE
BURROWS+LZW
BURROWS+MTF


"""