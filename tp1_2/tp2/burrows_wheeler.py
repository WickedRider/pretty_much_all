
# def bwtencode(text):
#     global L, F
#     L =''
#     F =''
#     text = text+"#"
#     last_str = text
#     len_text = len(text)
#     rotate_list = []
#     rotate_list.append(last_str)
#     for i in range(len_text-1):
#         last_str = last_str[-1] + last_str[-len_text:-1]
#         rotate_list.append(last_str)

#     sorted_list = sorted(rotate_list)
#     for eachstr in sorted_list:
#         L = L + eachstr[-1]
#         F = F + eachstr[0]
#     return L

# def C(c,encoded):
#     #Count the number of all characters in T whose lexicographic order is less than "c"

#     num_Tc = 0
#     for eachchr in encoded:
#         if c> eachchr:
#             num_Tc += 1
#     return num_Tc-1

# def Occ(c,r,encoded):
#     #Count the number of characters c appearing before the rth line in L
#     row = -1
#     num_Lc = 0
#     if r == 0:
#         return 0
#     for eachchr in encoded:
#         row += 1
#         if eachchr == c:
#             num_Lc += 1
#         if row == r-1:
#             break
#     return num_Lc

# def bwtdecode(encoded):
#     #Because of the existence of #, it can be determined that the last character in the original text must be in the first line of L (the first character)

#     r = 0
#     T =''

#     while encoded[r] != "#":
#         T = encoded[r] + T
#         c = encoded[r]
#         r = C(c,encoded) + Occ(c, r,encoded) + 1
#     print(T)


# def bwt(sequence):
#     sequence += '$'
#     table = [sequence[index:] + sequence[:index] for index, _ in enumerate(sequence)]
#     table.sort()
#     bwt = [rotation[-1] for rotation in table]
#     bwt = ''.join(bwt)
#     return bwt


# def inverse_bwt(sequence):
#     table = [col for col in sequence]
#     for i in range(len(sequence) - 1):
#         table.sort()
#         table = [sequence[i] + table[i] for i in range(len(sequence))]

#     return table[[row[-1] for row in table].index('$')]



def bwtencode(data):
    words = list(data)
    lista = []
    hold = ""
    for i in range(len(words)):
        word = data[-1] + data[:-1]
        new = ''.join(word)
        data = new
        lista.append(new)
        i += 1

    sort = sorted(lista)

    for i in range(len(words)):
        element = sort[i]
        last = element[- 1]
        i = i + 1
        hold += last
    
    return hold
