class Node:
    def __init__(self, prob, symbol, left = None, right = None):
        #probability of symbol
        self.prob = prob

        #symbol
        self.symbol = symbol

        #left node
        self.left = left

        #right node
        self.right = right

        #tree direction (0/1)
        self.code = ''

codes = dict()

def Huffman_Decoding(enconded_data, huffman_tree):
    """ function to decode Huffman Enconding\n enconded_data -> data\n huffman_tree -> tree from huffman enconding (second paramenter returned) """
    tree_head = huffman_tree
    decoded_output = []
    for x in enconded_data:
        if x == '1':
            huffman_tree = huffman_tree.right
        elif x == '0':
            huffman_tree = huffman_tree.left
        try:
            if huffman_tree.left.symbol == None and huffman_tree.right.symbol == None:
                pass
        except AttributeError:
            decoded_output.append(huffman_tree.symbol)
            huffman_tree = tree_head

    string = ''.join([str(item) for item in decoded_output])
    return string


def Huffman_Enconding(data):
    symbol_with_probs = Calculate_Prob(data)
    symbols = symbol_with_probs.keys()
    probabilities = symbol_with_probs.values()

    
    nodes = []

    #converting symbols and probabilities into huffman tree nodes
    for symbol in symbols:
        nodes.append(Node(symbol_with_probs.get(symbol), symbol))

    while(len(nodes) > 1):
        #sort alll the nodes in ascending order based on their probability
        nodes = sorted(nodes, key= lambda x: x.prob)

        right = nodes[0]
        left = nodes[1]

        left.code = 0
        right.code = 1

        newNode = Node(left.prob+right.prob, left.symbol+right.symbol, left, right)

        nodes.remove(left)
        nodes.remove(right)
        nodes.append(newNode)
    
    huffman_enconding = Calculate_Codes(nodes[0])
    print(huffman_enconding)
    Total_Gain(data, huffman_enconding)
    encoded_output = Output_Encoded(data, huffman_enconding)
    return encoded_output, nodes[0]




def Calculate_Prob(data):
    """ A helper function to calculate the probabilities of symbols in given data """
    symbols = dict()
    for element in data:
        if symbols.get(element) == None:
            symbols[element] = 1
        else:
            symbols[element] += 1
    return symbols


def Calculate_Codes(node, val=''):
    """ A helper function to print the codes of symbols by traveling the Huffman Tree """
    newVal = val + str(node.code)

    if(node.left):
        Calculate_Codes(node.left, newVal)
    if(node.right):
        Calculate_Codes(node.right, newVal)
    
    if(not node.left and not node.right):
        codes[node.symbol] = newVal
    
    return codes


def Total_Gain(data, coding):
    """ A helper function to calculate the space difference between compressed and non compressed data. (coding, is a dictionary that comes from Calculate_Codes) """
    before_compression = len(data) * 8
    after_compression = 0
    symbols = coding.keys()
    for symbol in symbols:
        count = data.count(symbol)
        after_compression += count * len(coding[symbol])

    print("Space before compression (in bits)", before_compression)
    print("Space after compression (in bits)", after_compression)

def Output_Encoded(data, coding):
    """ A helper function to obtain the encoded ouput """
    encoding_output = []
    for c in data:
        encoding_output.append(coding[c])
    
    string = ''.join([str(item) for item in encoding_output])
    return string
    