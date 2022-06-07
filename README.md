## 3단계 - 구간 추가 기능

### 기능 요구 사항

- [x] 역 사이에 새로운 역을 등록한다.
    * Given : 지하철 노선 생성하고
    * When : 기존 노선에 있는 상행역과 신규 하행역을 사이에 추가하면
    * Then : 추가된 노선을 사이에 포함하여 차례되로 조회되는 것을 볼 수 있다.

- [x] 새로운 역을 상행 종점으로 등록한다.
    * Given : 지하철 노선 생성하고
    * When : 신규 역을 상행 종점으로 하고, 기존의 상행 종점을 하행 역으로 추가하면
    * Then : 추가된 노선이 상행 종점이 된 상태로 차례대로 조회된다.

- [x] 새로운 역을 하행 종점으로 등록한다.
    * Given : 지하철 노선 생성하고
    * When : 신규 역을 하행 종점으로 하고, 기존의 하행 종점을 상행 역으로 추가하면
    * Then : 추가된 노선이 하행 종점이 된 상태로 차례대로 조회된다.

- [x] 역 사이에 새로운 역을 등록할 때, 기존 역 사이 길이보다 크거나 같게 등록한다.
    * Given : 지하철 노선 생성하고
    * When : 기존 노선에 있는 상행역과 신규 하행역을 사이에 추가하는데, 거리를 기존 노선보다 길게 하면
    * Then : 등록되지 않고 에러 발생

- [x] 상행역과 하행역이 이미 노선에 등록되있는 상태에서 등록을 한다.
    * Given : 지하철 노선을 생성하고
    * When : 이미 노선에 등록이 되어있는 역을 상행역과 하행역으로 하면
    * Then : 등록되지 않고 에러 발생

- [ ] 상행역과 하행역이 기존 노선에 하나도 포함되있지 않은 상태로 등록한다.
    * Given : 지하철 노선을 생성하고
    * When : 노선에 없는 역을 상행역과 하행역으로 하면
    * Then : 등록되지 않고 에러 발생
