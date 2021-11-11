#include <stdlib.h>
#include "rect.h"

void main (void) {
    rect* r1 = new_rect(10, 15, 20, 20);
    rect_print(r1);

    rect* r2 = new_rect(25, 35, 15, 15);
    rect_drag(r2, 15,23);
    rect_print(r2);

    free(r1);
    free(r2);
}
