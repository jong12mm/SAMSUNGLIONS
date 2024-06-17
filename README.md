<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화 좌석 예매</title>

    <!-- CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            width: 100%;
        }

        header {
            text-align: center;
            margin-bottom: 20px;
        }

        .screen {
            background-color: #ccc;
            height: 50px;
            margin-bottom: 20px;
            text-align: center;
            line-height: 50px;
            font-weight: bold;
        }

        .seat-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .seat {
            width: 30px;
            height: 30px;
            background-color: #444;
            margin: 5px;
            cursor: pointer;
            border-radius: 5px;
        }

        .seat.selected {
            background-color: #6feaf6;
        }

        .seat.reserved {
            background-color: #ccc;
            cursor: not-allowed;
        }

        .summary {
            margin-top: 20px;
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group select,
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            text-align: center;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <header>
        <h1>영화 좌석 예매</h1>
    </header>
    <main>
        <div class="screen">스크린</div>
        <div class="seat-container" id="seatContainer"></div>
        <div class="summary">
            <p id="selectedSeats">선택된 좌석: 없음</p>
            <p id="totalPrice">총 가격: 0원</p>
        </div>
        <form id="bookingForm" class="booking-form">
            <div class="form-group">
                <label for="name" class="form-label">이름</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="gameinfoId" class="form-label">게임 정보 ID</label>
                <input type="text" id="gameinfoId" name="gameinfoId" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="payid" class="form-label">결제 방법</label>
                <select id="payid" name="payid" class="form-control" required>
                    <option value="">결제 방법 선택</option>
                    <option value="card">카드</option>
                    <option value="bank">은행 이체</option>
                    <option value="mobile">모바일 결제</option>
                </select>
            </div>
            <div id="response"></div>
            <button type="submit" class="btn">예매완료</button>
        </form>
    </main>
    <footer>
        <p>© 2024 영화 예매 시스템</p>
    </footer>
</div>

<!-- JS -->
<script>
    document.addEventListener('DOMContentLoaded', () => {
        const seatContainer = document.getElementById('seatContainer');
        const selectedSeatsDisplay = document.getElementById('selectedSeats');
        const totalPriceDisplay = document.getElementById('totalPrice');
        const bookingForm = document.getElementById('bookingForm');

        const seatCount = 100;
        const seatsPerRow = 10;
        const seatPrice = 10000;

        // 좌석 생성
        for (let i = 0; i < seatCount; i++) {
            const row = Math.floor(i / seatsPerRow) + 1;
            const seatNumber = (i % seatsPerRow) + 1;
            const seat = document.createElement('div');
            seat.classList.add('seat');
            seat.setAttribute('data-seat', `R${row}S${seatNumber}`);
            seat.setAttribute('data-price', seatPrice);
            seatContainer.appendChild(seat);
        }

        // 좌석 클릭 이벤트
        seatContainer.addEventListener('click', (e) => {
            if (e.target.classList.contains('seat') && !e.target.classList.contains('reserved')) {
                e.target.classList.toggle('selected');
                updateSelectedSeats();
            }
        });

        // 선택된 좌석 업데이트
        function updateSelectedSeats() {
            const selectedSeats = document.querySelectorAll('.seat.selected');
            const selectedSeatsArr = Array.from(selectedSeats).map(seat => seat.getAttribute('data-seat'));
            const totalPrice = selectedSeatsArr.length * seatPrice;

            selectedSeatsDisplay.textContent = `선택된 좌석: ${selectedSeatsArr.length > 0 ? selectedSeatsArr.join(', ') : '없음'}`;
            totalPriceDisplay.textContent = `총 가격: ${totalPrice}원`;
        }

        // 예매 폼 제출 이벤트
        bookingForm.addEventListener('submit', (e) => {
            e.preventDefault();

            const name = document.getElementById('name').value;
            const gameinfoId = document.getElementById('gameinfoId').value;
            const payid = document.getElementById('payid').value;
            const selectedSeats = document.querySelectorAll('.seat.selected');
            const selectedSeatsArr = Array.from(selectedSeats).map(seat => seat.getAttribute('data-seat'));

            if (selectedSeatsArr.length === 0) {
                alert('최소 하나의 좌석을 선택해야 합니다.');
                return;
            }

            fetch('/book/make', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name: name,
                    gameinfoId: gameinfoId,
                    payid: payid,
                    seats: selectedSeatsArr
                })
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('예매가 완료되었습니다.');
                    location.reload();
                } else {
                    alert('예매에 실패했습니다. 다시 시도하세요.');
                }
            })
            .catch(error => {
                console.error('오류 발생:', error);
                alert('오류가 발생했습니다. 다시 시도하세요.');
            });
        });
    });
</script>
</body>
</html>
