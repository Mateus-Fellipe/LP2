#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct rect{
    int x, y, w, h;

    void(*print)(struct rect*);
    void(*drag)(struct rect*, int, int);
} rect;

rect* new_rect(int x, int y, int w, int h){ // Construção do objeto
    rect* pRect = malloc(sizeof(rect)); // Aloca uma espaço de memória para o ponteiro de rect
    
    pRect->print = rect_print;
    pRect->drag = rect_drag;

    pRect->x = x;
    pRect->y = y;
    pRect->w = w;
    pRect->h = h;

    return pRect;
}

void rect_print(rect* pRect){
    printf("Retangulo de tamanho (%d, %d), na posição (%d, %d).\n", pRect->w, pRect->h, pRect->x, pRect->y);
}

void rect_drag(rect* pRect, int distX, int distY){
    pRect->x += distX;
    pRect->y += distY;
}
