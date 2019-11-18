#include <stdio.h>
#define MAX_VERTEX_NUM 20
#define VertexRelationType int
#define InfoType char
#define VertexType int

typedef enum {DG,DN,UDG,UDN} GraphType

typedef struct {
   VertexRelationType adj;
   InfoType *info;
}Edge,EdgeMatrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM];

typedef struct{
  VertexType vertexes[MAX_VERTEX_NUM];
  EdgeMatrix edges;
  int vertexesCnt,edgesCnt;
  GraphType graphType;
}Graph


int locateVertex(Graph *graph,VertexType vertex){
  int i = 0;
  for(;i<graph->){

  }
}