def reverse_words_order_and_swap_cases(sentence):
    new_sentence = []
    for word in sentence.split(' ')[::-1]:
        new_letter = []
        for letter in word:
            new_letter.append(letter.lower() if letter.isupper() else letter.upper())
        new_sentence.append("".join(new_letter))
        
    return " ".join(new_sentence)


print(reverse_words_order_and_swap_cases("aWESOME is cODING"))